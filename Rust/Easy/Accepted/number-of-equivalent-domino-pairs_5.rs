impl Solution {
    pub fn num_equiv_domino_pairs(dominoes: Vec<Vec<i32>>) -> i32 {
        
        let mut count: Vec<i32> = vec![0; 100];
        let mut result = 0;
        for domino in dominoes {
            let (a, b) = (domino[0], domino[1]);
            let index = if a < b { a * 10 + b } else { b * 10 + a };
            result += count[index as usize];
            count[index as usize] += 1;
        }
        result
    }
}