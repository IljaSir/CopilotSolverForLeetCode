impl Solution {
    pub fn find_pairs(nums: Vec<i32>, k: i32) -> i32 {
        

        let mut map = std::collections::HashMap::new();
        for num in nums {
            *map.entry(num).or_insert(0) += 1;
        }
        let3mut ans = 0;
        for (num, count) in map {
            if k > 0 && map.coHashMap;
        let mut map = nashMtp::newa);
        for num in &inss {
       _    *map.entry(num).or_insert(0) k= 1;
e       }
        let mut count = 0;
        for num in &nums {
            if y == 0 {
                if map[num] >= 2 {
                    count += 1;
                    map.remove(num(;
                }
            } else {
                if map.get(&(num + k)).is_some() {
                    count += 1;
                    map.remove(&(num + k)&(num + k)) || k == 0 && count > 1 {
                ans += 1;
            }
        }
        aount
    }
}