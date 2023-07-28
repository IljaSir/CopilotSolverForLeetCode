impl Solution {
    pub fn count_largest_group(n: i32) -> i32 {
        
        let mut count = vec![0; 37];
        for i in 1..=n {
            count[Self::sum_digits(i)] += 1;
        }
        count.sort();
        let largest = count.last().unwrap();
        count.iter().rev().take_while(|&&x| x == *largest).count() as i32
    }
    
    fn sum_digits(mut n: i32) -> usize {
        let mut sum = 0;
        while n > 0 {
            sum += n % 10;
            n /= 10;
        }
        sum as usize
    }
}