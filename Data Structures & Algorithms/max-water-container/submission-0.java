class Solution {
    public int maxArea(int[] heights) {
        int left=0;
        int right=heights.length-1;
        int maxArea=0;
        while(left<right){
            int currentwidth=right-left;
            int currentHeight = Math.min(heights[left], heights[right]);
            int currentArea = currentwidth * currentHeight; 

            // Step 2: Max area update karo
            maxArea = Math.max(maxArea, currentArea);
            
            // Step 3: Jo deewar chhoti hai, us pointer ko khiskao
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            } 
        }
        return maxArea;
        
    }
}
