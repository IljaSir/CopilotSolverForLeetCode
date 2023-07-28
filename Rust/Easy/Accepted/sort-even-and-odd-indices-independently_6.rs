impl Solution {
    pub fn sort_even_odd(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        let mut odd = nums.iter().enumerate().filter(|&(i, _)| i % 2 == 1).map(|(_, &x)| x).collect::<Vec<i32>>();
        let mut even = nums.iter().enumerate().filter(|&(i, _)| i % 2 == 0).map(|(_, &x)| x).collect::<Vec<i32>>();
        odd.sort();
        odd.reverse();
        even.sort();
        let mut result = Vec::new();
        for i in 0..nums.len() {
            if i % 2 == 0 {
                result.push(even[i / 2]);
            } else {
                result.push(odd[i / 2]);
            }
        }
        result
    }
}