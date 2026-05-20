class Solution {
    public void sortColors(int[] nums) {
       int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        
        // Jab tak mid, high ko cross nahi karta
        while (mid <= high) {
            if (nums[mid] == 0) {
                // 0 mila: Low ke sath swap karo
                swap(nums, low, mid);
                low++;
                mid++;
            } 
            else if (nums[mid] == 1) {
                // 1 mila: Bas aage badho
                mid++;
            } 
            else if (nums[mid] == 2) {
                // 2 mila: High ke sath swap karo
                swap(nums, mid, high);
                high--; // Yahan mid ko ++ nahi karna hai!
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}