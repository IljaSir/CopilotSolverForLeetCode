impl Solution {
    pub fn num_subarrays_with_sum(nums: Vec<i32>, goal: i32) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut sum = 0;
        let mut ans = 0;
        for n in nums {
            map.entry(sum).and_modify(|v| *v += 1).or_insert(1);
            sum += n;
            ans += map.get(&(sum - goal)).unwrap_or(&0);
        }
        ans
    }
}