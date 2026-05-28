class Solution {
    public int[] sortArray(int[] nums) {
      mergeSort(nums,0,nums.length-1);
      return nums;  
    }
    // Divide karne wala function
    private void mergeSort(int[] arr, int left, int right) {
        // Base case: Agar array mein 1 ya 0 element bacha hai, toh ruk jao
        if (left >= right) {
            return;
        }
        
        int mid = left + (right - left) / 2;
        
        // Left hisse ko todo
        mergeSort(arr, left, mid);
        
        // Right hisse ko todo
        mergeSort(arr, mid + 1, right);
        
        // Dono hisson ko merge (jod) do
        merge(arr, left, mid, right);
    }
    
    // Jodne (Merge) karne wala function
    private void merge(int[] arr, int left, int mid, int right) {
        // Ek temporary (khali) array banayenge jisme sorted elements daalenge
        int[] temp = new int[right - left + 1];
        
        int i = left;      // Left array ka pointer
        int j = mid + 1;   // Right array ka pointer
        int k = 0;         // Temp array ka pointer
        
        // Dono arrays ko compare karke chhote element ko temp mein daalo
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        
        // Agar left array mein kuch bach gaya ho, toh use daal do
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        
        // Agar right array mein kuch bach gaya ho, toh use daal do
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        
        // Temp (sorted) array ke elements ko wapas asli array mein copy kar do
        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }
}