class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
      int left = 0;
      int right = arr.length - 1; 
      while(right-left>=k){
        int distLeft=Math.abs(arr[left]-x);
        int distRight=Math.abs(arr[right]-x);
        if(distLeft>distRight){
            left++;
        }else{
            right--;
        }
      } 
      // Final result ko list mein daal kar return karo
        List<Integer> result = new ArrayList<>();
        for(int i=left;i<=right;i++){
            result.add(arr[i]);
        }
        return result;
    }
}