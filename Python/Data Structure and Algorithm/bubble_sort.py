class BubbleSort:
    """Implements for bulble sort alogrithm (purpose of lass )"""
    def sort(self,arr):
        """(purpose of function)

        Args:
            arr(list): The list of be sorted
        Returns:
            list: sroted list
        """


        arr = arr.copy()
        n = len(arr)
        for i in range(n-1):
            for j in range(n-i-1):
                if arr[j] > arr[j+1]:
                    arr[j],arr[j+1] = arr[j+1],arr[j]
        return arr

if __name__ == "__main__":
    my_sort = BubbleSort()
    arr = [5, 2, 9, 1, 5, 6]
    sort_arr = my_sort.sort(arr)
    print("original list",arr)
    print("changed list",sort_arr)
