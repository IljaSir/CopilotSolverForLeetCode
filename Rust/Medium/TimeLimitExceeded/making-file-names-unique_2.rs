impl Solution {
    pub fn get_folder_names(names: Vec<String>) -> Vec<String> {
        
        let mut map = std::collections::HashMap::<String, i32>::new();
        let mut res = Vec::<String>::new();
        for name in names {
            let mut cur = name.clone();
            let mut i = 0;
            while map.contains_key(&cur) {
                i = map[&cur];
                i += 1;
                cur = format!("{}({})", name, i);
            }
            map.insert(cur.clone(), i);
            res.push(cur);
        }
        res
    }
}