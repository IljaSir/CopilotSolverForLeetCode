impl Solution {
    pub fn intersection(nums: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut arr = nums[0].clone();
        for i in 1..nums.len() {
            arr = arr
                .iter()
                .filter(|&x| nums[i].contains(x))
                .map(|x| *x)
                .collect();
        }
        arr
    }
}