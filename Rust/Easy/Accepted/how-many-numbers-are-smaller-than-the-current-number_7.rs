impl Solution {
    pub fn smaller_numbers_than_current(nums: Vec<i32>) -> Vec<i32> {
        
        let mut cnt = vec![0; 101];
        for num in nums.iter() {
            cnt[*num as usize] += 1;
        }
        for i in 1..cnt.len() {
            cnt[i] += cnt[i - 1];
        }
        nums.into_iter().map(|num| if num == 0 { 0 } else { cnt[num as usize - 1] }).collect()
    }
}