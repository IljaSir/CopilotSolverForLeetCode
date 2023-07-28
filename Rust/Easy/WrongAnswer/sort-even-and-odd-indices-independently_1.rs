impl Solution {
    pub fn sort_even_odd(nums: Vec<i32>) -> Vec<i32> {
        
        let mut even = nums.iter().enumerate().filter(|&(i, _)| i % 2 == 0).map(|(_, &x)| x).collect::<Vec<i32>>();
        let mut odd = nums.iter().enumerate().filter(|&(i, _)| i % 2 == 1).map(|(_, &x)| x).collect::<Vec<i32>>();
        even.sort();
        odd.sort();
        odd.reverse();
        even.iter().zip(odd.iter()).flat_map(|(x, y)| vec![*x, *y]).collect::<Vec<i32>>()
    }
}