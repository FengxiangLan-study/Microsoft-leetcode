class Solution {
    static class Event {
        int x;
        int h;
        int type;
        public Event(int x, int h, int type) {
            this.x = x;
            this.h = h;
            this.type = type;
        }
    }
    
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Event> events = new ArrayList<>();
        for (int[] building : buildings) {
            events.add(new Event(building[0], building[2], 1));
            events.add(new Event(building[1], building[2], -1));
        }
        
        Collections.sort(events, new Comparator<Event>() {
            @Override
            public int compare(Event one, Event two) {
                if (one.x == two.x) {
                    return two.h * two.type - one.h * one.type;
                }
                return one.x - two.x;
            }
        });
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer one, Integer two) {
                return two - one;
            }
        });
        
        List<List<Integer>> result = new ArrayList<>();
        maxHeap.add(0);
        int preHeight = 0;
        for (Event event : events) {
            if (event.type == 1) {
                maxHeap.add(event.h);
            } else {
                maxHeap.remove(event.h);
            }
            int curHeight = maxHeap.peek();
            if (curHeight != preHeight) {
                result.add(Arrays.asList(event.x, curHeight));
                preHeight = curHeight;
            }
        }
        return result;
    }
}