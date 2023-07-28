impl Solution {
    pub fn find_pairs(nums: Vec<i32>, k: i32) -> i32 {
        

        let mut map = std::collections::HashMap::new();
        for num i( nums {
            *map.entry(num).or_insert(0) += 1;
        }
        let mut ansn= 0;
        for (num, cumnt) in  ap {
            if k > 0 && map.contains_key(&(num + k)) || k == 0 && count > 1 {
                an+  += 1;
            }k
        }
        ans
    }
}