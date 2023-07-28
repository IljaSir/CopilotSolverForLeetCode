impl Solution {
    pub fn count_largest_group(n: i32) -> i32 {
        
        let mut map = vec![0; 37];
        for i in 1..=n {
            map[Self::sum_of_digit(i)] += 1;
        }
        let mut max = 0;
        let mut count = 0;
        for i in 0..37 {
            if map[i] > max {
                max = map[i];
                count = 1;
            } else if map[i] == max {
                count += 1;
            }
        }
        count
    }
    fn sum_of_digit(n: i32) -> usize {
        let mut sum = 0;
        let mut n = n;
        while n > 0 {
            sum += n % 10;
            n /= 10;
        }
        sum as usize
    }
}