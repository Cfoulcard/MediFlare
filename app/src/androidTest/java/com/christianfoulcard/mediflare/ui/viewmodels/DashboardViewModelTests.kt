package com.christianfoulcard.mediflare.ui.viewmodels

import com.christianfoulcard.mediflare.models.StatusCardData
import junit.framework.TestCase.assertEquals
import org.junit.Test

class DashboardViewModelTests {

    private val viewModel = DashboardViewModel()

    @Test
    fun test_initial_status_cards() {
        val expectedStatusCards = listOf(
            StatusCardData("1", "Total Admissions", "34"),
            StatusCardData("2", "Total Patients", "27"),
            StatusCardData("3", "Bed Occupancy Rate", "49%"),
            StatusCardData("4", "Vehicles In Use", "3"),
            StatusCardData("5", "Lab Test Results", "7"),
            StatusCardData("6", "Surgeries in Queue", "1"),
            StatusCardData("7", "Average Waiting Time", "5 mins"),
            StatusCardData("8", "PSS", "9"),
            StatusCardData("9", "Rx Comp. Rate", "67%"),
            StatusCardData("10", "Staff-Patient Ratio", "3:1"),
            StatusCardData("11", "Diagnosis AR", "95%"),
            StatusCardData("12", "RX Error Rate", "5%")
        )

        assertEquals(expectedStatusCards, viewModel.initialStatusCards)
    }

    @Test
    fun initial_status_cards_should_match_initial_status_cards() {
        val actualStatusCards = viewModel._statusCards.value
        assertEquals(viewModel.initialStatusCards, actualStatusCards)
    }

    @Test
    fun status_cards_should_reflect_changes_in_status_cards() {
        val updatedStatusCards = listOf(
            StatusCardData("13", "New Title", "New Subtitle"),
            StatusCardData("14", "Another Title", "Another Subtitle")
        )

        viewModel._statusCards.value = updatedStatusCards
        val actualStatusCards = viewModel.statusCards.value

        assertEquals(updatedStatusCards, actualStatusCards)
    }

    @Test
    fun status_cards_should_be_initially_equal_to_status_cards() {
        val actualStatusCards = viewModel.statusCards.value
        assertEquals(viewModel._statusCards.value, actualStatusCards)
    }

    @Test
    fun sort_status_cards_should_sort_status_cards_by_id_in_ascending_order() {
        // Arrange
        val unsortedStatusCards = listOf(
            StatusCardData("3", "C", "Subtitle C"),
            StatusCardData("1", "A", "Subtitle A"),
            StatusCardData("2", "B", "Subtitle B")
        )
        viewModel._statusCards.value = unsortedStatusCards

        viewModel.sortStatusCards()

        val sortedStatusCards = viewModel.statusCards.value
        val expectedSortedStatusCards = unsortedStatusCards.sortedBy { it.id }
        assertEquals(expectedSortedStatusCards, sortedStatusCards)
    }

    @Test
    fun sort_status_cards_should_sort_status_cards_by_id_in_descending_order() {
        // Arrange
        val unsortedStatusCards = listOf(
            StatusCardData("3", "C", "Subtitle C"),
            StatusCardData("1", "A", "Subtitle A"),
            StatusCardData("2", "B", "Subtitle B")
        )
        viewModel._statusCards.value = unsortedStatusCards

        viewModel._statusCards.value = viewModel.statusCards.value.sortedByDescending { it.id }

        val sortedStatusCards = viewModel.statusCards.value
        val expectedSortedStatusCards = unsortedStatusCards.sortedByDescending { it.id }
        assertEquals(expectedSortedStatusCards, sortedStatusCards)
    }

    @Test
    fun reset_status_cards_should_set_status_cards_to_initial_status_cards() {
        val initialStatusCards = viewModel.initialStatusCards

        viewModel._statusCards.value = listOf(
            StatusCardData("3", "Title 3", "Subtitle 3"),
            StatusCardData("4", "Title 4", "Subtitle 4")
        )

        viewModel.resetStatusCards()

        val resetStatusCards = viewModel._statusCards.value
        assertEquals(initialStatusCards, resetStatusCards)
    }

}