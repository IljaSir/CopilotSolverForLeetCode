impl Solution {
    pub fn is_happy(n: i32) -> bool {
        
        let mut n = n;
        let mut sum = 0;
        let mut nums: Vec<i32> = Vec::new();
        while n != 1 {
            while n != 0 {
                sum += (n % 10).pow(2);
                n /= 10;
            }
            if nums.contains(&sum) {
                return false;
            }
            nums.push(sum);
            n = sum;
            sum = 0;
        }
        true
    }
}