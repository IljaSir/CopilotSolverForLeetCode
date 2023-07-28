impl Solution {
    pub fn num_equiv_domino_pairs(dominoes: Vec<Vec<i32>>) -> i32 {
        
        let mut counter = vec![0; 100];
        let mut result = 0;
        for domino in dominoes {
            let x = domino[0];
            let y = domino[1];
            let key = if x < y { x * 10 + y } else { y * 10 + x };
            result += counter[key as usize];
            counter[key as usize] += 1;
        }
        result
    }
}