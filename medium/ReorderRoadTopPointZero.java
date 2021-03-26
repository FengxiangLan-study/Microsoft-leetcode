class Solution {
    public int minReorder(int n, int[][] connections) {
        int result = 0;
        Map<Integer, List<Integer>> parents = new HashMap<>();
        Map<Integer, List<Integer>> childrens = new HashMap<>();
        for (int[] c : connections) {
            int parent = c[0];
            int child = c[1];
            List<Integer> parentList = parents.getOrDefault(c[1], new ArrayList<>());
            parentList.add(c[0]);
            parents.put(c[1], parentList);
            List<Integer> childList = childrens.getOrDefault(c[0], new ArrayList<>());
            childList.add(c[1]);
            childrens.put(c[0], childList);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                visited.add(cur);
                
                List<Integer> parent = parents.getOrDefault(cur, new ArrayList<>());
                List<Integer> child = childrens.getOrDefault(cur, new ArrayList<>());
                
                for (int p : parent) {
                    if (!visited.contains(p)) {
                        queue.offer(p);
                    }
                }
                
                for (int c : child) {
                    if (!visited.contains(c)) {
                        queue.offer(c);
                        result++;
                    }
                }
            }
        }
        return result;
    }
}

// Time Cost: O(n + m) m is connections.length
// Space Cost: O(n)


class Solution {
    public int minReorder(int n, int[][] connections) {
        boolean[] toZero = new boolean[n];
        toZero[0] = true;
        int count = 0, size = 1;
        while(size<n) {
            for(int [] arr : connections) {
                if(toZero[arr[1]]) {
                    if(!toZero[arr[0]]) {
                        toZero[arr[0]] = true;
                        size++;
                    }
                }
                else if(toZero[arr[0]]) {
                    toZero[arr[1]] = true;
                    count++;
                    size++;
                }
            }
        }
        
        return count;
    }
}

// Time Cost: O(n)
// Space Cost: O(n)