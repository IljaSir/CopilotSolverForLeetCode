impl Solution {
    pub fn num_subarrays_with_sum(nums: Vec<i32>, goal: i32) -> i32 {
        
        let mut sum = 0;
        let mut map: std::collections::HashMap<i32, i32> = std::collections::HashMap::new();
        let mut res = 0;
        for n in nums {
            map.entry(sum).and_modify(|e| *e += 1).or_insert(1);
            sum += n;
            res += map.get(&(sum - goal)).unwrap_or(&0);
        }
        res
    }
}