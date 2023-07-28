impl Solution {
    pub fn delete_and_earn(nums: Vec<i32>) -> i32 {
        
        let mut sums = vec![0; 10001];
        for num in nums {
            sums[num as usize] += num;
        }
        let (mut take, mut skip) = (0, 0);
        for sum in sums {
            let take_i = skip + sum;
            let skip_i = take.max(skip);
            take = take_i;
            skip = skip_i;
        }
        take.max(skip)
    }
}