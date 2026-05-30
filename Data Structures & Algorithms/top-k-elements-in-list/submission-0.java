class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Buckets banao (Array of Lists)
        // Array ka size nums.length + 1 hoga, kyunki max frequency array ki length ke barabar ho sakti hai
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        
        // Step 3: Piche se buckets padho aur Top K nikalo
        int[] result = new int[k];
        int counter = 0;
        
        for (int i = buckets.length - 1; i >= 0 && counter < k; i--) {
            if (buckets[i] != null) {
                // Ek bucket mein ek se zyada numbers bhi ho sakte hain (tie hone par)
                for (int num : buckets[i]) {
                    result[counter++] = num;
                    if (counter == k) {
                        return result; // K log milte hi seedha return
                    }
                }
            }
        }
        
        return result;
        
    }
}
