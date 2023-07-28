impl Solution {
    pub fn check_if_exist(arr: Vec<i32>) -> bool {
        
        let mut set = HashSet::new();
        for i in arr {
            if set.contains(&(i * 2)) || (i % 2 == 0 && set.contains(&(i / 2))) {
                return true;
            }
            set.insert(i);
        }
        false
    }
}