impl Solution {
    pub fn frequency_sort(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        nums.sort();
        let mut ans = Vec::new();
        let mut count = 0;
        let mut last = nums[0];
        for i in 0..nums.len() {
            if nums[i] == last {
                count += 1;
            } else {
                ans.push((last, count));
                count = 1;
                last = nums[i];
            }
        }
        ans.push((last, count));
        ans.sort_by(|a, b| {
            if a.1 == b.1 {
                b.0.cmp(&a.0)
            } else {
                a.1.cmp(&b.1)
            }
        });
        ans.iter().flat_map(|(n, c)| vec![*n; *c as usize]).collect()
    }
}