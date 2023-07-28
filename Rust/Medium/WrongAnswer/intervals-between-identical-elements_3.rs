impl Solution {
    pub fn get_distances(arr: Vec<i32>) -> Vec<i64> {
        
        let mut indexes: Vec<Vec<i32>> = vec![vec![]; 100001];
        for (i, &x) in arr.iter().enumerate() {
            indexes[x as usize].push(i as i32);
        }
        let mut distances: Vec<i64> = vec![0; arr.len()];
        for i in 0..indexes.len() {
            let mut sum = 0;
            let mut count = 0;
            for j in 0..indexes[i].len() {
                let index = indexes[i][j] as usize;
                sum += count * (index as i64) - distances[index];
                count += 1;
                distances[index] = sum;
            }
            sum = 0;
            count = 0;
            for j in (0..indexes[i].len()).rev() {
                let index = indexes[i][j] as usize;
                sum += count * (arr.len() as i64 - index as i64 - 1) - distances[index];
                count += 1;
                distances[index] += sum;
            }
        }
        distances
    }
}