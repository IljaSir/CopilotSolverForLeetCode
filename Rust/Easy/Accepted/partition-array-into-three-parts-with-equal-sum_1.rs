impl Solution {
    pub fn can_three_parts_equal_sum(arr: Vec<i32>) -> bool {
        
        let sum: i32 = arr.iter().sum();
        if sum % 3 != 0 {
            return false;
        }
        let target = sum / 3;
        let mut count = 0;
        let mut sum = 0;
        for i in 0..arr.len() {
            sum += arr[i];
            if sum == target {
                sum = 0;
                count += 1;
            }
        }
        count >= 3
    }
}