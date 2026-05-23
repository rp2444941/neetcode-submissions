class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
     if (nums == null || k <= 0) return new int[0];
        
        int n = nums.length;
        int[] result = new int[n - k + 1]; // Result array ka size
        int resultIndex = 0;
        
        // Deque array ke indices store karegi
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            
            // Step 1: Purane kachre (expired elements) ko aage se nikalo
            // Agar sabse aage wala element current window ke bahar chala gaya hai
            if (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }
            
            // Step 2: Naye element se chhote elements ko pichhe se laat maar kar nikalo
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            
            // Step 3: Naye element (uski index) ko line mein add karo
            dq.offerLast(i);
            
            // Step 4: Agar humari pehli window ban chuki hai (i >= k - 1),
            // toh sabse aage wala element humara max hoga
            if (i >= k - 1) {
                result[resultIndex++] = nums[dq.peekFirst()];
            }
        }
        
        return result;   
    }
}
