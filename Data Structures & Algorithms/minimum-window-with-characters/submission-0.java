class Solution {
    public String minWindow(String s, String t) {
       if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        // Target list (Frequency map using ASCII array)
        int[] targetFreq = new int[128];
        for (char c : t.toCharArray()) {
            targetFreq[c]++;
        }
        int left = 0;
        int right = 0;
        int matchCount = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;
while (right < s.length()) {
            char rightChar = s.charAt(right);
            
            // Agar right character humari list mein tha, toh matchCount badhao
            if (targetFreq[rightChar] > 0) {
                matchCount++;
            }
            
            // Item ko cart mein daala (count kam kiya)
            // Note: Faltu letters negative me chale jayenge, jisse pata chalega wo extra hain
            targetFreq[rightChar]--;
            right++;

            // Jab saara saman mil jaye (Valid Window)
            while (matchCount == t.length()) {
                
                // Naya sabse chhota answer save karo
                if (right - left < minLen) {
                    minLen = right - left;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);
                
                // Left wale item ko wapas shelf par rakho (count badhao)
                targetFreq[leftChar]++;
                
                // Agar wo item zaroori tha (> 0), toh cart se nikalne par matchCount kam ho jayega
                if (targetFreq[leftChar] > 0) {
                    matchCount--;
                }
                
                // Window ko pichhe se shrink karo
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    
    }
}
