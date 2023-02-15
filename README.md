Meeting Scheduler

Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration, return the earliest time slot that works for both of them. If there is no common time slot that satisfies the requirements, return an empty array. It is guaranteed that no two availability slots of the same person intersect with each other. That is, for any two time slots [start1, end1] and [start2, end2] of the same person, either start1 > end2 or start2 > end1.

Example 1:

Input: slots1 = [[30,50],[55,90],[95,120]], slots2 = [[0,15],[60,100]], duration = 30

Output: [60,90]

Example 2:

Input: slots1 = [[30,50],[55,80],[120,180]], slots2 = [[10,15],[90,120]], duration = 15

Output: []

Example 3:

Input: slots1 = [[30,50],[95,120],[55,90]]slots2 = [[60,100], [0,15]]duration = 30 //unsorted slots

Output: [60,90]