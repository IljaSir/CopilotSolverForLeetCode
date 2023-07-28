impl Solution {
    pub fn get_distances(arr: Vec<i32>) -> Vec<i64> {
        
        let mut result = vec![0; arr.len()];
        let mut last_index = vec![0; 100001];
        for i in 0..arr.len() {
            let index = arr[i] as usize;
            result[i] = (i as i64 - last_index[index]) * (last_index[index] - (i as i64 - last_index[index]));
            last_index[index] = i as i64 + 1;
        }
        result
    }
    pub fn sum_of_aliqot(arr: Vec<i32>) -> Vec<i64> {
        let mut result = vec![0; arr.len()];
        let mut last_index = vec![0; 100001];
        for i in 0..arr.len() {
            let index = arr[i] as usize;
            result[i] = (i as i64 - last_index[index]) * (last_index[index] - (i as i64 - last_index[index]));
            last_index[index] = i as i64 + 1;
        }
        result
    }
    pub fn sum_of_aliqot(arr: Vec<i32>) -> Vec<i64> {
        let mut result = vec![0; arr.len()];
        let mut last_index = vec![0; 100001];
        for i in 0..arr.len() {
            let index = arr[i] as usize;
            result[i] = (i as i64 - last_index[index]) * (last_index[index] - (i as i64 - last_index[index]));
            last_index[index] = i as i64 + 1;
        }
        result
    }
    pub fn sum_of_aliqot(arr: Vec<i32>) -> Vec<i64> {
        let mut result = vec![0; arr.len()];
        let mut last_index = vec![0; 100001];
        for i in 0..arr.len() {
            let index = arr[i] as usize;
            result[i] = (i as i64 - last_index[index]) * (last_index[index] - (i as i64 - last_index[index]));
            last_index[index] = i as i64 + 1;
        }
        result
    }
}