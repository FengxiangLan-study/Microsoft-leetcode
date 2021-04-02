class Solution {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            Integer suffix = map.get(names[i]);
            if (suffix == null) {
                map.put(names[i], 0);
            } else {
                suffix += 1;
                String newName = names[i] + "(" + suffix + ")";
                while (map.containsKey(newName)) {
                    suffix++;
                    newName = names[i] + "(" + suffix + ")";
                }
                map.put(names[i], suffix);
                map.put(newName, 0);
                names[i] = newName;
            }
        }
        return names;
    }
}