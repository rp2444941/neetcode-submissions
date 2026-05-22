class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            // Naya character add karo aur maxFreq update karo
            char currentChar = s.charAt(right);
            counts[currentChar - 'A']++;
            maxFreq = Math.max(maxFreq, counts[currentChar - 'A']);
            
            // Golden Rule Check: Agar (Length - maxFreq) > k, toh Invalid hai
            // Isliye Left ko aage badha kar window ko shift karo
            if ((right - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);
                counts[leftChar - 'A']--;
                left++;
            }
            
            // Max length update karo (kyunki upar wale if ne invalid window ko shrink kar diya hoga)
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
