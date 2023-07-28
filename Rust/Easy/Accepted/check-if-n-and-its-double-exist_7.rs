impl Solution {
    pub fn check_if_exist(arr: Vec<i32>) -> bool {
        
        let mut map = std::collections::HashMap::new();
        for i in 0..arr.len() {
            if arr[i] % 2 == 0 {
                if let Some(_) = map.get(&(arr[i]/2)) {
                    return true;
                }
            }
            if let Some(_) = map.get(&(arr[i]*2)) {
                return true;
            }
            map.insert(arr[i], i);
        }
        false
    }
}