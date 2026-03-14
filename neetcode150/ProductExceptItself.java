package neetcode150;

public class ProductExceptItself {
    /**
     * Time: O(n^2)
     * Space: O(1)
     * 
     * @param nums
     * @return
     */
    public int[] productExceptItself1(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) product = product * nums[j];
            }
            res[i] = product;
        } 
        return res;
    }

    /**
     * Time: O(n)
     * Space: O(1)
     * 
     * @param nums
     * @return
     */
    public int[] productExceptItself2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // prefix product
        res[0] = 1;
        for (int i = 1; i < n; i++)
            res[i] = res[i - 1] * nums[i - 1];

        // suffix product
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * suffix;
            suffix = suffix * nums[i];
        }
        
        return res;
    }
}
