impl Solution {
    pub fn original_digits(s: String) -> String {
        

        let mut counter = [0; 26];
        for c in s.chars() {
            counter[c as usize - 'a' as usize] += 1;
        }
        let mut res = vec![];
        for i in 0..10 {
            let mut c = '0';
            let mut count = 0;
            match i {
                0 => {
                    c = 'z';
                    count = counter[c as usize - 'a' as usize];
                    res.append(&mut vec![0; count]);
                }
                2 => {
                    c = 'w';
                    count = counter[c as usize - 'a' as usize];
                    res.append(&mut vec![2; count]);
                }
                4 => {
                    c = 'u';
                    count = counter[c as usize - 'a' as usize];
                    res.append(&mut vec![4; count]);
                }
                6 => {
                    c = 'x';
                    count = counter[c as usize - 'a' as usize];
                    res.append(&mut vec![6; count]);
                }
                8 => {
                    c = 'g';
                    count = counter[c as usize - 'a' as usize];
                    res.append(&mut vec![8; count]);
                }
                1 => {
                    c = 'o';
                    count = counter[c as usize - 'a' as usize] - res[0] - res[2] - res[4];
                    res.append(&mut vec![1; count]);
                }
                3 => {
                    c = 'r';
                    count = counter[c as usize - 'a' as usize] - res[0] - res[4];
                    res.append(&mut vec![3; count]);
                }
                5 => {
                    c = 'f';
                    count = counter[c as usize - 'a' as usize] - res[4];
                    res.append(&mut vec![5; count]);
                }
                7 => {
                    c = 'v';
                    count = counter[c as usize - 'a' as usize] - res[5];
                    res.append(&mut vec![7; count]);
                }
                9 => {
                    c = 'i';
                    count = counter[c as usize - 'a' as usize] - res[5] - res[6] - res[8];
                    res.append(&mut vec![9
    }
}