package neetcode150;

public class ContainerWithMostWater {
    public static int maxArea(int[] heights) {
        int maxArea = 0;
        int left = 0;
        int right = heights.length - 1;
        while (left < right) {
            int min = Math.min(heights[left], heights[right]);
            maxArea = Math.max(maxArea, min * (right - left));
            if (heights[left] < heights[right]) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        return maxArea;
    }
}
