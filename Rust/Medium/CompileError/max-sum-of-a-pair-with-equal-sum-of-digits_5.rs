impl Solution {
    pub fn maximum_sum(nums: Vec<i32>) -> i32 {
        
        let mut max = -1;
        let mut max1 = -1;
        let mut max2 = -1;
        for num in nums {
            let sum = Self::sum_of_digits(num);
            if sum > max {
                max = sum;
                max1 = num;
            } else if sum == max {
                max1 = std::cmp::max(max1, num);
            }
        }
        for num in nums {
            let sum = Self::sum_of_digits(num);
            if sum == max && num != max1 {
                max2 = std::cmp::max(max2, num);
            }
        }
        if max1 == -1 || max2 == -1 {
            return -1;
        }
        max1 + max2
    }
    fn sum_of_digits(num: i32) -> i32 {
        let mut sum = 0;
        let mut num = num;
        while num > 0 {
            sum += num % 10;
            num /= 10;
        }
        sum
    }
}