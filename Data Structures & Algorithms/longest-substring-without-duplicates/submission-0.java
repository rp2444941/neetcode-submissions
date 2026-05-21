class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while (right < s.length()) {
            char currentChar = s.charAt(right);
            if (!set.contains(currentChar)) {
                set.add(currentChar);       // Set mein daalo
                maxLength = Math.max(maxLength, right - left + 1); // Max length update karo
                right++;                    // Window ko aage badhao (Expand)
            }else {
                set.remove(s.charAt(left)); // Pichhe se ek character nikalo
                left++;                     // Window ko pichhe se chhota karo (Shrink)
                // Note: right abhi bhi wahi hai, agle loop mein phir se check hoga
            }
        }
        return maxLength;
    }
}
