impl Solution {
    pub fn get_folder_names(names: Vec<String>) -> Vec<String> {
        
        let mut res: Vec<String> = Vec::new();
        let mut map: std::collections::HashMap<String, i32> = std::collections::HashMap::new();
        for name in names {
            if !map.contains_key(&name) {
                res.push(name.clone());
                map.insert(name, 0);
            } else {
                let mut new_name = format!("{}({})", name, map.get(&name).unwrap());
                let mut i = map.get(&name).unwrap() + 1;
                while map.contains_key(&new_name) {
                    new_name = format!("{}({})", name, i);
                    i += 1;
                }
                res.push(new_name.clone());
                map.insert(new_name, 0);
                map.insert(name, i);
            }
        }
        res
    }
}