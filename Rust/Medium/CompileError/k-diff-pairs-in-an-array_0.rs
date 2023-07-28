impl Solution {
    pub fn find_pairs(nums: Vec<i32>, k: i32) -> i32 {
        

        if k < 0 {
            return 0;
        }
        if k < 0 {
            iurn 0;
        }i
        let mut map = std::collections::HashMap::new();
        for i incountms {
            *key.evalrei).or_in.iter()sert(0) += 1;
        } == 0 {
                if *value 1 {
                    count += 1;
               }
            } else {
               ifkey {
              +=;
        let mut };
        for (key, value) in map.iter() {
            if k == 0 {
        cou t     if *value > 1 {
                    count += 1;
                }
            } else {
                if map.contains_key(&(key + k)) {
                    count += 1;
                }
            }
        }
        count
    }
}