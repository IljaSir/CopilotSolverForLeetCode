impl Solution {
    pub fn can_three_parts_equal_sum(arr: Vec<i32>) -> bool {
        
        let sum = arr.iter().sum::<i32>();
        if sum % 3 != 0 {
            return false;
        }
        let mut left = 0;
        let mut right = arr.len() - 1;
        let mut left_sum = arr[left];
        let mut right_sum = arr[right];
        while left + 1 < right {
            if left_sum == right_sum && left_sum == sum / 3 {
                return true;
            }
            if left_sum != sum / 3 {
                left += 1;
                left_sum += arr[left];
            }
            if right_sum != sum / 3 {
                right -= 1;
                right_sum += arr[right];
            }
        }
        false
    }
}