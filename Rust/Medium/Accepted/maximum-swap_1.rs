impl Solution {
    pub fn maximum_swap(num: i32) -> i32 {
        

        let mut num = num.to_string().into_bytes();
        let mut idx = vec![0; 10];
        for i in 0..num.len() {
            idx[(num[i] - b'0') as usize] = i;
        }
        for i in 0..num.len() {
            for d in (0..10).rev() {
                if d > (num[i] - b'0') as usize && idx[d] > i {
                    num.swap(i, idx[d]);
                    return String::from_utf8(num).unwrap().parse().unwrap();
                }
            }
        }
        num.iter().fold(0, |acc, &x| acc * 10 + (x - b'0') as i32)
    }
}