class Solution {
    public int firstMissingPositive(int[] nums) {
     int n = nums.length;
        
        // Phase 1: Har number ko uski sahi kursi (index) par bithao
        for (int i = 0; i < n; i++) {
            // Conditions:
            // 1. Number positive hona chahiye (nums[i] > 0)
            // 2. Number N se chhota ya barabar hona chahiye (nums[i] <= n)
            // 3. Number pehle se apni sahi jagah par NAHI hona chahiye
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                
                // Swap karne ka magic
                int correctIndex = nums[i] - 1; // Jaise 3 ki correct index 2 hai
                int temp = nums[correctIndex];
                nums[correctIndex] = nums[i];
                nums[i] = temp;
            }
        }
        
        // Phase 2: Array mein ghoom kar pehla khali (ya galat) dibba dhoondho
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                // Agar index 'i' par 'i+1' nahi hai, toh wahi missing hai
                return i + 1;
            }
        }
       
        return n + 1;
    }
}