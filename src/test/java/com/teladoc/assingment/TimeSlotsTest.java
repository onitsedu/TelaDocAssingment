package com.teladoc.assingment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TimeSlotsTest {

    @Test
    void firstTestCaseProvided() {
        int[][] slots1 = {{30, 50}, {55, 90}, {95, 120}};
        int[][] slots2 = {{0, 15}, {60, 100}};
        int duration = 30;
        int[] result = TimeSlots.findEarliestMatchingSlot(slots1, slots2, duration);
        Assertions.assertArrayEquals(result, new int[]{60, 90});
    }

    @Test
    void secondTestCaseProvided() {
        int[][] slots1 = {{30, 50}, {55, 80}, {120, 180}};
        int[][] slots2 = {{10, 15}, {90, 120}};
        int duration = 15;
        int[] result = TimeSlots.findEarliestMatchingSlot(slots1, slots2, duration);
        Assertions.assertArrayEquals(result, new int[]{});
    }

    @Test
    void thirdTestCaseProvided() {

        int[][] slots1 = {{30, 50}, {55, 90}, {95, 120}};
        int[][] slots2 = {{0, 15}, {60, 100}};
        int duration = 30;
        int[] result = TimeSlots.findEarliestMatchingSlot(slots1, slots2, duration);
        Assertions.assertArrayEquals(result, new int[]{60, 90});
    }


    @Test
    void oneEmptyArraySlots() {

        int[][] slots1 = {{30, 50}, {55, 90}, {95, 120}, {195, 220}};
        int[][] slots2 = {};
        int duration = 30;
        int[] result = TimeSlots.findEarliestMatchingSlot(slots1, slots2, duration);
        Assertions.assertArrayEquals(result, new int[]{});
    }

    @Test
    void bothEmptyArraySlots() {

        int[][] slots1 = {};
        int[][] slots2 = {};
        int duration = 30;
        int[] result = TimeSlots.findEarliestMatchingSlot(slots1, slots2, duration);
        Assertions.assertArrayEquals(result, new int[]{});
    }

    @Test
    void moreThanOneSlot() {

        int[][] slots1 = {{30, 50}, {55, 90}, {155, 190}};
        int[][] slots2 = {{0, 15}, {60, 100}, {160, 200}};
        int duration = 30;
        int[] result = TimeSlots.findEarliestMatchingSlot(slots1, slots2, duration);
        Assertions.assertArrayEquals(result, new int[]{60, 90});
    }

    @Test
    void slotInsideOtherSlot() {

        int[][] slots1 = {{30, 50}, {135, 200}};
        int[][] slots2 = {{60, 100}, {150, 190}};
        int duration = 30;
        int[] result = TimeSlots.findEarliestMatchingSlot(slots1, slots2, duration);
        Assertions.assertArrayEquals(result, new int[]{150, 190});
    }

    @Test
    void twoSlotsInsideOtherSlot() {

        int[][] slots1 = {{30, 200}};
        int[][] slots2 = {{60, 100}, {150, 190}};
        int duration = 30;
        int[] result = TimeSlots.findEarliestMatchingSlot(slots1, slots2, duration);
        Assertions.assertArrayEquals(result, new int[]{60, 100});
    }

    @Test
    void twoContiguousSlotsIntersection() {

        int[][] slots1 = {{30, 100}, {100, 200}};
        int[][] slots2 = {{80, 110}};
        int duration = 30;
        int[] result = TimeSlots.findEarliestMatchingSlot(slots1, slots2, duration);
        Assertions.assertArrayEquals(result, new int[]{80, 110});
    }

    @Test
    void twoNonContiguousSlotsIntersection() {

        int[][] slots1 = {{30, 100}, {101, 200}};
        int[][] slots2 = {{80, 110}};
        int duration = 30;
        int[] result = TimeSlots.findEarliestMatchingSlot(slots1, slots2, duration);
        Assertions.assertArrayEquals(result, new int[]{});
    }

    @Test
    void slotsNoLongerEnough() {

        int[][] slots1 = {{10, 200}};
        int[][] slots2 = {{15, 30}, {45, 60}};
        int duration = 30;
        int[] result = TimeSlots.findEarliestMatchingSlot(slots1, slots2, duration);
        Assertions.assertArrayEquals(result, new int[]{});
    }
}
