class Solution {
    public boolean isPalindrome(String s) {
        int left=0;
        int right=s.length()-1;
        while(left<right){
         if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Agar right par koi space ya symbol hai, toh use skip karke pichhe aao
            else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            // Jab dono pointers sirf asili letters/numbers par aa jayein
            else {
                // Dono ko choti ABCD (lowercase) mein badal kar compare karo
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false; // Agar phir bhi alag hain, toh Palindrome nahi hai
                }
                
                // Agar match kar gaya, toh agle characters par badho
                left++;
                right--;
            }   
        }
        return true;
    }
}
