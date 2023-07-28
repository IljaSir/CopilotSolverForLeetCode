impl Solution {
    pub fn can_three_parts_equal_sum(arr: Vec<i32>) -> bool {
        
        let sum = arr.iter().sum::<i32>();
        if sum % 3 != 0 {
            return false;
        }
        let mut count = 0;
        let mut sum = 0;
        for &n in arr.iter() {
            sum += n;
            if sum == sum / 3 {
                count += 1;
                sum = 0;
            }
        }
        count == 3
    }
}