class Solution {
    public String minimizeError(String[] prices, int target) {
        // first convert all prices to Floor
        // if sum bigger than target, means impossible, return '-1';
        // else we change each floorValue to ceilValue, once we change one, sum = sum + 1, will close to target;
        // to minimize the rounding, we should always first choose the element whose diff((hight - i) - (i - floor)) is smallest
        // so when we floor all elements, we store diff((hight - i) - (i - floor)) to minHeap
        float result = 0;
        PriorityQueue<Double> diffHeap = new PriorityQueue<Double>();
        
        for (String s : prices) {
            float f = Float.valueOf(s);
            double low = Math.floor(f);
            double high = Math.ceil(f);
            
            if (low != high)
                diffHeap.offer((high-f)-(f-low));
            
            result += f-low;
            target -= low;
        }
        
        // target < 0 means sum of floor already bigger than target
        // target > diffHeap.size even revert all element to ceil one, sum still smaller than target
        if (target < 0 || target > diffHeap.size()) {
            return "-1";
        }
        
        while (target > 0) {
            result += diffHeap.poll();
            // since the (hight - low) = 1, so once we convert one floor value to ceil value, sum will close to target;
            target--;
        }
        
        return String.format("%.3f", result);
    }
}

// Time Cost: O(nlogn)
// Space Cost: O(n)
