class Solution {
    public int longestConsecutive(int[] nums) {
         if (nums == null || nums.length == 0) {
            return 0;
        }

        // Step 1: HashSet mein saare numbers daal do
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // Step 2: Set (ya array) ke har element ko check karo
        for (int num : numSet) {
            
            // Check karo ki kya yeh sequence ka STARTING number hai?
            // Agar num-1 set mein nahi hai, tabhi yeh starting number hoga
            if (!numSet.contains(num - 1)) {
                
                int currentNum = num;
                int currentStreak = 1;

                // Jab tak sequence aage badh rahi hai, check karte raho
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                // Longest sequence ko update karo
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
