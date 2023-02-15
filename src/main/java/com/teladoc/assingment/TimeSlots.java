package com.teladoc.assingment;

import java.util.*;

public class TimeSlots {

    public static int[] findEarliestMatchingSlot(final int[][] slots1, final int[][] slots2, final int duration) {
        //Early exit
        if (slots1.length == 0 || slots2.length == 0) {
            return new int[]{};
        }

        List<int[]> mergedSlots1 = mergeContiguousSlots(slots1).stream()
                .filter(slot -> isDurationEnough(slot, duration)).toList();
        List<int[]> mergedSlots2 = mergeContiguousSlots(slots2).stream()
                .filter(slot -> isDurationEnough(slot, duration))
                .sorted(Comparator.comparingInt(a -> a[0])).toList();

        //Early exit
        if (mergedSlots1.size() == 0 || mergedSlots2.size() == 0) {
            return new int[]{};
        }

        return mergedSlots1.stream().map(slot1 ->
                mergedSlots2.stream()
                        .filter(slot2 -> isOverlapping(slot1, slot2))
                        .map(slot2 -> matches(slot1, slot2, duration))
                        .filter(Objects::nonNull)
                        .min(Comparator.comparingInt(slot -> slot[0]))
                        .orElse(new int[]{})
        ).findFirst().orElse(new int[]{});
    }


    /**
     * Check if slot is long enough
     *
     * @param slot
     * @param duration
     * @return
     */
    private static boolean isDurationEnough(final int[] slot, final int duration) {
        return slot[1] - slot[0] >= duration;
    }

    /**
     * Process slots and merge slots that finish and starts in the same instant to become a single slot
     * ex:
     * [[10,20],[20,50]] => [[10,50]]
     *
     * @param slots
     * @return
     */
    private static List<int[]> mergeContiguousSlots(final int[][] slots) {
        List<int[]> mergedSlots = new ArrayList<>();
        Arrays.stream(slots)
                .sorted(Comparator.comparing(slot -> slot[0]))
                .forEach(slot -> {
                    if (mergedSlots.size() > 0) {
                        int[] previousSlot = mergedSlots.get(mergedSlots.size() - 1);
                        if (previousSlot[1] == slot[0]) {
                            mergedSlots.set(mergedSlots.size() - 1, new int[]{previousSlot[0], slot[1]});
                        } else {
                            mergedSlots.add(slot);
                        }
                    } else {
                        mergedSlots.add(slot);
                    }
                });
        return mergedSlots;
    }

    /**
     * Check if two slots overlaps
     *
     * @param slot1
     * @param slot2
     * @return
     */
    private static boolean isOverlapping(final int[] slot1, final int[] slot2) {
        return (slot1[0] <= slot2[1]) && (slot1[1] >= slot2[0]);
    }

    /**
     * Checks if two slots overlaps time enough and returns the overlapping slot time
     *
     * @param slot1
     * @param slot2
     * @param duration
     * @return slot matching, null otherwise
     */
    private static int[] matches(final int[] slot1, final int[] slot2, final int duration) {
        int start = Math.max(slot1[0], slot2[0]);
        int end = Math.min(slot1[1], slot2[1]);
        if (end - start >= duration) {
            System.out.println("matches [" + start + "," + end + "]");
            return new int[]{start, end};
        }
        return null;
    }

}
