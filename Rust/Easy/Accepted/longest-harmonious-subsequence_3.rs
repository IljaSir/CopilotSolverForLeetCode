impl Solution {
    pub fn find_lhs(nums: Vec<i32>) -> i32 {
        
        let mut map: std::collections::HashMap<i32, i32> = std::collections::HashMap::new();
        for num in nums {
            let count = map.entry(num).or_insert(0);
            *count += 1;
        }
        let mut res = 0;
        for (num, count) in map.iter() {
            if map.contains_key(&(num + 1)) {
                res = res.max(*count + map[&(num + 1)]);
            }
        }
        res
    }
}