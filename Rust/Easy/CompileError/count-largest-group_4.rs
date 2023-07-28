impl Solution {
    pub fn count_largest_group(n: i32) -> i32 {
        
        let mut v = vec![0; 37];
        for i in 1..=n {
            v[i.to_string().chars().map(|c| c.to_digit(10).unwrap() as usize).sum::<u32>() as usize] += 1;
        }
        let max = v.iter().max().unwrap();
        v.iter().filter(|&x| x == max).count() as i32
    }
}