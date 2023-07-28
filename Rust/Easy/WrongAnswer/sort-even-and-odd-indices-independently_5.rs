impl Solution {
    pub fn sort_even_odd(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        let mut odd = nums.iter().filter(|&x| x % 2 == 1).collect::<Vec<_>>();
        let mut even = nums.iter().filter(|&x| x % 2 == 0).collect::<Vec<_>>();
        odd.sort();
        even.sort();
        let mut odd = odd.iter().rev().map(|x| **x).collect::<Vec<_>>();
        let mut even = even.iter().map(|x| **x).collect::<Vec<_>>();
        let mut result = vec![];
        while !odd.is_empty() || !even.is_empty() {
            if !even.is_empty() {
                result.push(even.remove(0));
            }
            if !odd.is_empty() {
                result.push(odd.remove(0));
            }
        }
        result
    }
}