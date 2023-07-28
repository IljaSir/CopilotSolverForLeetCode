impl Solution {
    pub fn original_digits(s: String) -> String {
        

        let mut cnts = vec![0; 26];
        for c in s.chars() {
            cnts[(c as u8 - b'a') as usize] += 1;
        }
        let mut res = vec![];
        let mut zero = cnts[b'z' as usize - b'a' as usize];
        let mut two = cnts[b'w' as usize - b'a' as usize];
        let mut four = cnts[b'u' as usize - b'a' as usize];
        let mut six = cnts[b'x' as usize - b'a' as usize];
        let mut eight = cnts[b'g' as usize - b'a' as usize];
        let mut one = cnts[b'o' as usize - b'a' as usize] - zero - two - four;
        let mut three = cnts[b'r' as usize - b'a' as usize] - zero - four;
        let mut five = cnts[b'f' as usize - b'a' as usize] - four;
        let mut seven = cnts[b's' as usize - b'a' as usize] - six;
        let mut nine = cnts[b'i' as usize - b'a' as usize] - five - six - eight;
        res.append(&mut vec![0; zero]);
        res.append(&mut vec![1; one]);
        res.append(&mut vec![2; two]);
        res.append(&mut vec![3; three]);
        res.append(&mut vec![4; four]);
        res.append(&mut vec![5; five]);
        res.append(&mut vec![6; six]);
        res.append(&mut vec![7; seven]);
        res.append(&mut vec![8; eight]);
        res.append(&mut vec![9; nine]);
        res.into_iter().map(|x| (x + b'0') as char).collect()
    }
}