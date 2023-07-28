impl Solution {
    pub fn can_three_parts_equal_sum(arr: Vec<i32>) -> bool {
        
        let sum = arr.iter().sum::<i32>();
        if sum % 3 != 0 {
            return false;
        }
        let target = sum / 3;
        let mut sum = 0;
        let mut count = 0;
        for &num in arr.iter() {
            sum += num;
            if sum == target {
                sum = 0;
                count += 1;
            }
        }
        count >= 3
    }
}